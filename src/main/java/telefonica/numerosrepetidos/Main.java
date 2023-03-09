package telefonica.numerosrepetidos;

/**
 * Enunciado: de un array num�rico, realizar un m�todo est�tico que devuelva si alguno de los n�meros est� repetido
 * dos veces o m�s.
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

//		int[] arrayInt = {0,1,2,3,4,7,2,5,6,7,8,9,10,11,12,2,13,2,14,15};
		int[] arrayInt = {0,1,3,4,7,5,6,7,8,9,10,11,12,2,13,14,15};
		
		System.out.println(checkAnyRepeatedNumber(arrayInt) ? "Hay alg�n n�mero repetido." : "No hay ning�n n�mero repetido.");
		
		int repetitions = 2;
		Map<Integer, Integer> repNumbers = findRepeatedNumbers(arrayInt, repetitions);
		System.out.println(repNumbers.size() > 0 ? "Hay alg�n n�mero repetido " + repetitions + " o m�s veces."
			: "No hay ning�n n�mero repetido " + repetitions + " veces.");
		System.out.println(checkRepeatedNumbers(arrayInt, repetitions) ? "Hay alg�n n�mero repetido " + repetitions + " o m�s veces."
			: "No hay ning�n n�mero repetido " + repetitions + " veces.");
		System.out.println(checkRepeatedNumbersInMapInsertion(arrayInt, repetitions) ? "Hay alg�n n�mero repetido " + repetitions + " o m�s veces."
				: "No hay ning�n n�mero repetido " + repetitions + " veces.");
		
//		repNumbers.values().forEach(n -> System.out.println(n));
//		repNumbers.entrySet().forEach(element -> System.out.println(element.getKey() + " : " + element.getValue()));
		
		Persona persona = new Persona();
		try {
			persona.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.gc();

	}
	
	// Este m�todo solo sirve para averiguar si alg�n n�mero se repite una o m�s veces.
	// Si os lo plantean as� es una soluci�n bastante eficiente por ser concurrente.
	private static boolean checkAnyRepeatedNumber(int[] arrayInt) {
		
		return Arrays.stream(arrayInt).parallel().distinct().count() < arrayInt.length;
		
	}
	
	/*Esta soluci�n tiene la ventaja de terminar las repeticiones del bucle principal al encontrar el primer n�mero
	 * que se repite 'repetitions' veces, pero tiene el inconveniente de requerir un bucle anidado al llamar a
	 * 'Collections.frequency'
	 */	
	private static boolean checkRepeatedNumbers(int[] arrayInt, int repetitions) {

		final List<Integer> listInt = Arrays.stream(arrayInt).boxed().collect(Collectors.toList());
		
		for(int n : arrayInt) {
			
			if(Collections.frequency(listInt, n) > repetitions) {
				return true;
			}
		}
		
		return false;
		
	}
	
	/* Esta es la soluci�n con la que estuvo m�s conforme, por usar HashMap. Tambien es concurrente pero usa un bucle
	 * anidado con 'Collections.frequency'. Adem�s no se detiene al llegar al primer n�mero que se repite 'repetitions'
	 * veces.
	 */
	private static Map<Integer, Integer> findRepeatedNumbers(int[] arrayInt, int repetitions) {
		
		Map<Integer, Integer> repNumbers = new HashMap<Integer, Integer>();
		final List<Integer> listInt = Arrays.stream(arrayInt).boxed().collect(Collectors.toList());
				
		Arrays.stream(arrayInt).parallel().distinct().forEach(noRep -> {
			int r = Collections.frequency(listInt, noRep);
			if(r > repetitions) {
				
				repNumbers.put(noRep, r);
				
			}
			
		});
		
		return repNumbers;
		
	}
	
	/*
	 * Soluci�n basada en encontrar claves repetidas en el HashMap, tal como sugiri� Pablo. Seguramente sea la mejor
	 * soluci�n porque solo realiza una vuelta al bucle y se detiene al encontrar el n�mero repetido en el array.
	 */
	private static boolean checkRepeatedNumbersInMapInsertion(int[] arrayInt, int repetitions) {
		
		Map<Integer, Integer> repNumbers = new HashMap<Integer, Integer>();
		int rep = 0;
		final int ONE = 1;
		
		for(int n : arrayInt) {
			
			if(repNumbers.containsKey(n)) {
				rep = repNumbers.get(n) + ONE;
				if(rep > repetitions) {
					return true;
				}
				repNumbers.put(n, rep);
			}else {
				repNumbers.put(n, ONE);
			}
			
		}
		return false;
	}

}