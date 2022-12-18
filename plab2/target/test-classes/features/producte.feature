
Feature: Producte

  
  #escenari 1: poder afegir a la cistella un producte desde la pantalla d'aquest
  @tag1
	Scenario: Seleccio producte pagina principal
	
	Given LUsuari entra a la pagina web
 	When LUsuari clica sobre el producte que linteresa
 	And LUsuari selecciona la quantitat 
  And LUsuari clica sobre el boto add to cart per afegir
  Then Es confirma que sha afegit correctament el producte

	
	#escenari 2: poder afegir una review d'un producte 
	@tag2
	Scenario: Afegir una review dun producte
	
	Given LUsuari entra a la pagina web
 	When LUsuari clica sobre el producte CANON EOS 5D a la pagina principal
 	And LUsuari clica al boto de reviews
  And LUsuari emplena el formulari de la review amb les dades <review> <nom>
  And LUsuari clica al boto de continue per guardar la review
  Then Es confirma que sha guardat la review del producte
  
	Examples:
 	| nom       |  review                                                  |
  | Laura     |  Producte molt bonic esteticament i molt facil dutilitzar|
  


  