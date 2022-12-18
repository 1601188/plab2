

Feature: Cistella

	#escenari 1: Afegir un producte a la cistella
	@tag1
  Scenario: Afegir un producte a la cistella
  
  Given Pagina principal 
 	When LUsuari clica a un producte 
  And LUsuari lafegeix a la cistella
  Then El producte sha afegit a la cistella correctament
  

	#escenari 2: Eliminar un producte desde la cistella
	@tag2
  Scenario: Eliminar un producte a la cistella
  
  Given Pagina principal 
 	When LUsuari clica a un producte 
  And LUsuari lafegeix a la cistella
  Then El producte sha afegit a la cistella correctament
  And LUsuari clica a la cistella per visualitzar els seus productes
  And LUsuari elimina un dels seus productes
  Then El producte sha eliminat correctament de la cistella

  #escenari 3: Avisar de que no hi ha stock dun producte a la cistella
  @tag3
	Scenario: Stock no disponible
  
  Given Pagina principal 
 	When LUsuari clica a un producte 
  And LUsuari lafegeix a la cistella
  Then El producte sha afegit a la cistella correctament
  And LUsuari clica a la cistella per visualitzar els seus productes
  Then Es mostra un missatge de que no hi ha stock del producte

