package hackerrank.cases.restapiassessment.totalgoals;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    private static final ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("javascript");
    private static final String HOME_URL = "https://jsonmock.hackerrank.com/api/football_matches?year=%d&team1=%s&page=%d";
    private static final String VISITING_URL = "https://jsonmock.hackerrank.com/api/football_matches?year=%d&team2=%s&page=%d";

    public static int getTotalGoals(String team, int year) throws ScriptException {

        return getTotalGoals(team, year, HOME_URL) + getTotalGoals(team, year, VISITING_URL);
    }

    // Method to get the total goals scored by a team, both playing at home and away, in a single URL/page.
    public static int getTotalGoals(String team, int year, String url) throws ScriptException {

        // First page of results JSON
        String jsonFirstPage = fetchData(String.format(url, year, team, 1));
        if (jsonFirstPage != null && !jsonFirstPage.isEmpty()) {

            // Fetching the total pages from the first page, so it will be known how many pages are needed to query
            int homeTeamTotalPages = getTotalPages(jsonFirstPage);

            // Requesting all the pages to add all the goals of the team in the year.
            return IntStream.range(1, homeTeamTotalPages + 1).map(page -> {
                // Fetching the data from the page URL
                String json = json = fetchData(String.format(url, year, team, page));
                assert json != null;
                try {
                    // Adding the goals indicated in each URL/page to return the result.
                    return parseJsonForTeamGoals(json, team);
                } catch (ScriptException e) {
                    throw new RuntimeException(e);
                }
            }).sum();
        } else {
            throw new RuntimeException();
        }
    }
    // Method to get the JSON data as a String from the API URL.
    private static String fetchData(String apiUrl) {

        String json = null;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            json = reader.lines().collect(Collectors.joining());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    // Method to obtain the total pages of results from the first page of results
    private static int getTotalPages(String json) throws ScriptException {
        assert json != null;
        return Integer.valueOf(getJsonAttributeValueByName(json, "total_pages"));
    }

    // Method to get the value of a simple attribute from a JSON by it's name
    private static String getJsonAttributeValueByName(String json, String attName) throws ScriptException {

        StringBuilder stringBuilder = new StringBuilder("var obj = JSON.parse('" + json + "');");
        stringBuilder.append(String.format("var %s = obj.%s.toString();", attName, attName));

        scriptEngine.eval(stringBuilder.toString());

        String resultAtt = (String) scriptEngine.get(attName);

        if (resultAtt == null) {
            throw new RuntimeException(String.format("An error happened when retrieving the attribute '%s' from the server", attName));
        } else {
            return resultAtt;
        }

    }

    // Method to obtain a list of values (in a 'String' separated by commas) of an array contained in a JSON, from the name of the list and the attribute content in it.
    private static String getJsonAttributesFromJsonArray(String json, String attName) throws ScriptException {

        final String result = "result";
        final String[] attNames = attName.split("\\.");

        StringBuilder stringBuilder = new StringBuilder("var obj = JSON.parse('" + json + "');" + "var result = \"\";" );
        stringBuilder.append(String.format("var data = obj.%s;", attNames[0]));
        stringBuilder.append(String.format("for(var i = 0; i < %s.length; i++) {", attNames[0]));
        stringBuilder.append(String.format("var goals = %s[i].%s;", attNames[0], attNames[1]));
        stringBuilder.append("result += goals + \",\";");
        stringBuilder.append("}");
        stringBuilder.append("result = result.slice(0, -1);");

        scriptEngine.eval(stringBuilder.toString());

        return (String) scriptEngine.get(result);

    }

    // Method to obtain a list of the goals scored by a team at home matches from the JSON.
    private static String getHomeGoals(String json, String team) throws ScriptException {

        final String result = "result";
        final String attName = "team1goals";

        StringBuilder stringBuilder = new StringBuilder("var obj = JSON.parse('" + json + "');");
        stringBuilder.append("var result = \"\";");
        stringBuilder.append("var data = obj.data;");
        stringBuilder.append("for(var i = 0; i < data.length; i++) {");
        stringBuilder.append(String.format("if(data[i].team1.toString().equals('%s')) { ", team.trim()));
        stringBuilder.append(String.format("var goals = data[i].%s;", attName));
        stringBuilder.append("result += goals + \",\";");
        stringBuilder.append("}");
        stringBuilder.append("}");
        stringBuilder.append("result = result.slice(0, -1);");

        scriptEngine.eval(stringBuilder.toString());

        String goals = (String) scriptEngine.get(result);

        return goals != null && !goals.isEmpty() ? goals : "0";

    }
    // Method to obtain a list of the goals scored by a team at visiting matches form the JSON.
    private static String getVisingGoals(String json, String team) throws ScriptException {

        final String result = "result";
        final String attName = "team2goals";

        StringBuilder stringBuilder = new StringBuilder("var obj = JSON.parse('" + json + "');");
        stringBuilder.append("var result = \"\";");
        stringBuilder.append("var data = obj.data;");
        stringBuilder.append("for(var i = 0; i < data.length; i++) {");
        stringBuilder.append(String.format("if(data[i].team2.toString().equals('%s')) { ", team.trim()));
        stringBuilder.append(String.format("var goals = data[i].%s;", attName));
        stringBuilder.append("result += goals + \",\";");
        stringBuilder.append("}");
        stringBuilder.append("}");
        stringBuilder.append("result = result.slice(0, -1);");

        scriptEngine.eval(stringBuilder.toString());

        String goals = (String) scriptEngine.get(result);

        return goals != null && !goals.isEmpty() ? goals : "0";

    }
    // Method to get the sum of all the goals that a team has scored both at home and as a visitor.
    private static int parseJsonForTeamGoals(String json, String team) throws ScriptException {

        String homeGoals = getHomeGoals(json, team);
        String visitingGoals = getVisingGoals(json, team);
        final String splitRegex = ",";

        return Stream.concat(homeGoals != null && !homeGoals.isEmpty() ? Arrays.stream(homeGoals.split(splitRegex)) : Stream.of("0"),
                visitingGoals != null && !visitingGoals.isEmpty() ? Arrays.stream(visitingGoals.split(splitRegex)) : Stream.of("0")).mapToInt(Integer::valueOf).sum();
    }

}

public class Solution {


}

