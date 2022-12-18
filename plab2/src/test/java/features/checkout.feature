Feature: Comprar productes 

	#escenari 1: verificar que no es pot comprar quan la cistella es buida
	@tag1
	Scenario: Intentar comprar productes quan la cistella es buida
	    
	Given LUsuari es a la pagina principal
	When LUsuari clica comprar a la opcio del header
	Then  Se li avisa de que no te productes a la cistella
	
	#escenari 2: verificar que es pot comprar desde un guest
	@tag2
	Scenario: Intentar comprar productes quan la cistella te productes desde un usuari convidat
	    
	Given LUsuari es a la pagina principal
	When LUsuari afegeix un producte 
	And LUsuari clica a la cistella per poder fer checkout
	And LUsuari clica a lopcio checkout de la cistella
	Then Se li mostra la pagina per omplir les seves dades
	And LUsuari omple les seves dades 
	Then Es verifica que sha confirmat la comanda

	#escenari 3: verificar que es pot comprar desde un usuari registrat
	@tag3
	Scenario: Intentar comprar productes quan la cistella te productes desde un usuari loggejat
	    
	Given LUsuari es a la pagina principal
	When LUsuari afegeix un producte
	And LUsuari inicia sessio <email> <password> 
	And LUsuari clica a la cistella per poder fer checkout
	And LUsuari clica a lopcio checkout de la cistella
	Then Se li mostra la pagina per omplir les seves dades
	And LUsuari confirma les seves dades ja guardades
	Then Es verifica que sha confirmat la comanda
	
	Examples:
	| email            | password |
	| exemple@gmail.com|exemple111|
	
	
	
		
	
		

