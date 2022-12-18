Feature: Categories

	#escenari 1: verificar que es poden filtrar productes d'una categoria 
	@tag1
	Scenario: filtrar productes per preu
	    
	Given LUsuari entra a OpenCart
	When LUsuari clica sobre una categoria
	And LUsuari filtra els productes de menor a major preu
	Then  Se li ha de mostrar els productes ordenats per preu
	
	
	#escenari 2: verificar que es pot canviar de categoria desde el menu flotant a l'esquerra
	@tag2
	Scenario: canviar de categoria desde el menu flotant 
	
	Given LUsuari entra a OpenCart
	When LUsuari clica sobre una categoria desplegable
	And LUsuari clica a un altra tipus de producte de la categoria desde el menu flotant
	Then  Se li ha de mostrar els productes de una altre categoria 
