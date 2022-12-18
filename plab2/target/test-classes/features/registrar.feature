

Feature: Registre Usuari
 
 	#escenari 1: registre d'un usuari correctament
 	
	@tag1
	Scenario: Registre dun usuari nou a la pagina
	    
	Given LUsuari entra la pagina web
	When LUsuari li dona a lopcio registrar 
	Then Se li Mostra el formulari que ha de emplenar
	And LUsuari Inserta les dades <name> <lastname> <telefon> <password>
	And LUsuari accepta la politica de privacitat
	And LUsuari Clica sobre Login per confirmar les dades
	Then Sha de mostrar una pagina de confirmacio de creacio de Usuari
	
	Examples:
	| name | lastname | telefon  | password |
	|Laura | Gomez    |655555555 | 1234    | 
	
	
	#escenari 2: registre amb correu existent
	 
	@tag2
	Scenario: Registre dun usuari nou a la pagina amb email existent
	    
	Given LUsuari entra la pagina web
	When LUsuari li dona a lopcio registrar 
	Then Se li Mostra el formulari que ha de emplenar
	And LUsuari inserta <name> <lastname> <email> <telefon> <password>
	And LUsuari accepta la politica de privacitat
	And LUsuari Clica sobre Login per confirmar les dades
	Then Sha de mostrar una pagina indicant que el mail existeix
	
	Examples:
	| name | lastname | email             | telefon  | password |
	|Laura | Gomez    | exemple@gmail.com |655555555 | 1234     | 
	  
  