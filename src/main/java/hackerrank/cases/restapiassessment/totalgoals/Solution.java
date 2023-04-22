package hackerrank.cases.restapiassessment.totalgoals;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.io.BufferedReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {

    private static String HOME_URL = "https://jsonmock.hackerrank.com/api/football_matches?year=%d&team1=%s&page=%d";
    private static String VISITING_URL = "https://jsonmock.hackerrank.com/api/football_matches?year=%d&team2=%s&page=%d";

    private static final ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("javascript");

    public static int getTotalGoals(String team, int year) throws ScriptException {

        return getTotalGoals(team, year, HOME_URL) + getTotalGoals(team, year, VISITING_URL);
    }
    public static int getTotalGoals(String team, int year, String url) throws ScriptException {

        String jsonFirstPage = fetchData(String.format(url, year, team, 1));
        if(jsonFirstPage != null && !jsonFirstPage.isEmpty()) {
            int homeTeamTotalPages = getTotalPages(jsonFirstPage);

            return IntStream.range(1,homeTeamTotalPages +1).map(page -> {
                String json = json = fetchData(String.format(url, year, team, page));
                assert json != null;
                return parseJsonForTeamGoals(json, team);
            }).sum();
        }else {
            throw new RuntimeException();
        }


    }

    // Método para obtener el número total de páginas de resultados en la API
    private static int getTotalPages(String json) throws ScriptException {
        assert json != null;
        return (int) getJsonAttributeValueByName(json, "total_pages");
    }
    private static Object getJsonAttributeValueByName(String json, String attName) throws ScriptException {

        StringBuilder javascript = new StringBuilder("var obj = JSON.parse('" + json + "');");
        javascript.append(String.format("var %s = obj.%s;", attName, attName));

        scriptEngine.eval(javascript.toString());

        Object resultAtt = scriptEngine.get(attName);

        if(resultAtt == null) {
            throw new RuntimeException(String.format("An error happened when retrieving the attribute '%s' from the server", attName));
        } else {
            return resultAtt;
        }

        //return json.split("\"" + attName + "\":")[1].split(",")[0].trim();

    }

    // Método para obtener los datos JSON de la API
    private static String fetchData(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String json = reader.lines().collect(Collectors.joining());
            reader.close();

            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para analizar el JSON y obtener el número de goles del equipo
    // Método para analizar el JSON y obtener el número de goles del equipo
    private static int parseJsonForTeamGoals(String json, String team) {
        int totalGoals = 0;
        String[] matches = json.split("\"data\":\\[")[1].split("\\],\"page\":")[0].split("\\},\\{");
        for (String match : matches) {
            String team1 = match.split("\"team1\":\"")[1].split("\"")[0];
            //String team1 = getJsonAttributeValueByName(match, "team1");
            String team2 = match.split("\"team2\":\"")[1].split("\"")[0];
            //String team2 = getJsonAttributeValueByName(match, "team2");
            int team1Goals = Integer.parseInt(match.split("\"team1goals\":\"")[1].split("\"")[0]);
            int team2Goals = Integer.parseInt(match.split("\"team2goals\":\"")[1].split("\"")[0]);

            if (team1.equals(team)) {
                totalGoals += team1Goals;
            }
            if (team2.equals(team)) {
                totalGoals += team2Goals;
            }
        }

        return totalGoals;
    }

}
public class Solution {


}

