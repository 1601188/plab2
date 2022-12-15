
Feature: OpenCart
	
	#escenari 1: carrega de la pagina web correctament i visualitzacio de les categories 
 
	Scenario: Mostrar la pagina dinici correctament
	    
	Given LUsuari entra a la pagina principal de OpenCart
	When la pagina es carrega correctament 
	Then Confirmem que la pagina es carrega i mostra les opcions disponibles correctament 
	
	#escenari 2: accedir a les categories amb menus no desplegables
	
	Scenario: Accedir a les categories del menu no desplegables
	    
	Given LUsuari entra a la pagina principal de OpenCart
	When LUsuari clica sobre la opcio <article> del menu
	Then La pagina mostra <article> 
	
	Examples:
	|article|
	|Tablets|
	|Software| 
	|Cameras|

	#escenari 3: login d'un usuari creat

  Scenario: Login Usuari
  
  Given LUsuari entra a la pagina principal de OpenCart
 	When LUsuari clica a la opcio de Login
  And LUsuari fica <email> <password> 
  And LUsuari clica al boto login
  Then LUsuari fa login correctament
  
  Examples:
 	| email             | password   |
  | exemple@gmail.com | exemple111 |
  
  #escenari 4: accedir a les categories amb menus desplegables
	#per cada categoria hi ha diferents opcions, com ho podem fer?
	
	Scenario: Accedir a les categories del menu desplegables
	    
	Given LUsuari entra a la pagina principal de OpenCart
	When LUsuari clica sobre la opcio <article> del menu desplegable
	Then Mostra les opcions del menu desplegabla de la categoria <numero>
	
	Examples:
	|article | numero |
	|Desktops| 1 |
	|Laptops & Notebooks| 2 |
	|Components| 3 |
	|MP3 Players| 4 |
	
	#escenari 5: registre d'un usuari correctament
	#com faig x testejar el registre
	
	Scenario: Registre dun usuari nou a la pagina
	    
	Given LUsuari entra a la pagina principal de OpenCart
	When LUsuari clica sobre la opcio registrar 
	Then Se li Mostra el formulari que ha de emplenar
	And LUsuari Inserta les dades <name> <lastname> <email> <telefon> <password>
	And LUsuari accepta la politica de privacitat
	And LUsuari Clica sobre Login per confirmar les dades
	Then Sha de mostrar una pagina de confirmacio de creacio de Usuari
	
	Examples:
	| name | lastname | email                | telefon  | password |
	|Laura | Gomez    | lauragomez16@gmail.com |655555555 | 1234    | 
	

    
  #escenari 6: Un usuari fa logout 
  
  Scenario: LoGout Usuari
  
	Given LUsuari entra a la pagina principal de OpenCart
 	When LUsuari clica a la opcio de Login
  And LUsuari fica <email> <password> 
  And LUsuari clica al boto login
  And LUsuari fa login correctament
  And LUsuari vol tancar sessio i clica al boto LogOut 
  Then Sha de tancar la sessio del Usuari
  
	  Examples:
 	| email             | password   |
  | exemple@gmail.com | exemple111 |
  
  
	#escenari 7: Si es fa click a un producte a la pagina principal
	#que es mostri la descripcio i el preu correctament
	
	Scenario: Seleccio producte pagina principal
	
	Given LUsuari entra a la pagina principal de OpenCart
 	When LUsuari clica sobre un producte <producte>
  Then Es mostra el producte <producte> amb detalls i preu
  
	  Examples:
 	| producte         | 
  | MacBook          | 
  | iPhone           |    
  | Apple Cinema 30" | 
  | Canon EOS 5D     | 

  
  #escenari 8: poder afegir a la cistella un producte i que s'actulitzi el preu total 
  
  	
	Scenario: Seleccio producte pagina principal
	
	Given LUsuari entra a la pagina principal de OpenCart
 	When LUsuari clica sobre un producte iPhone
 	And LUsuari selecciona la quantitat 
  And LUsuari clica sobre el boto add to cart per afegir
  Then Es confirma que sha afegit correctament el producte

	
	#escenari 9: poder afegir una review d'un producte 
	
	Scenario: Afegir una review dun producte
	
	Given LUsuari entra a la pagina principal de OpenCart
 	When LUsuari clica sobre el producte CANON EOS 5D a la pagina principal
 	And LUsuari clica al boto de reviews
  And LUsuari emplena el formulari de la review amb les dades <review> <nom>
  And LUsuari clica al boto de continue per guardar la review
  Then Es confirma que sha guardat la review del producte
  
	Examples:
 	| nom       |  review                                                  |
  | Laura     |  Producte molt bonic esteticament i molt facil dutilitzar|
	
	#escenari 10: poder afegir productes a la cistella
	

  #escenari 10: poder afegir un producte a la wish list
  
  
  #escenari 11: poder accedir a la cistella desde els dos botons disponibles 
  #i si es buida que ens retorni un missatge de que es buida
  
  #escenari 12: eliminar un producte correctament 
  
  #escenari 13: verificar si es pot fer formulari de compra per poder comprar productes 
  
  #escenari 14: verificar que es pot recuperar la contrsenya oblidada
  
  #escenari 15: verificar que es pot fer el canvi de moneda 
  
  #escenari 16: verificar que es pot buscar un producte al buscador 
  
  #escenari 17: verificar que es pot canviar d'imatge a la pagina principal tant clicant
  # al boto com a la fletcha
  
  #escenari 18: verificar que es pot afegir a la cistella, afegir a la wish list i comparar desde la pagina principal
  
  #escenari 19: verificar que es pot accedir a les opcions de sobre el peu de pagina
  
  #escenari 20: verificar que es poden filtrar productes d'una categoria 
  
  #escenari 21: verificar que es pot utilitzar cupons, tarjetes de regal
  
  #escenari 22: verificar que l'usuari pugui calcular el seu preu d'enviament
  
  #escenari 23: verificar que s'avisi a l'usuari amb un missatge quan no pugui comprar 
  # quan no esta en stock

  
 
