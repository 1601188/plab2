
Feature: OpenCart Pagina principal

	#escenari 1: Mostrar la pagina dinici correctament
	@tag1
	Scenario: Mostrar la pagina dinici correctament
	    
	Given LUsuari entra a la pagina principal de OpenCart
	When la pagina es carrega correctament 
	Then Confirmem que la pagina es carrega i mostra les opcions disponibles correctament 
	
	#escenari 2: accedir a les categories amb menus no desplegables
	@tag2
	Scenario: Accedir a les categories del menu no desplegables
	    
	Given LUsuari entra a la pagina principal de OpenCart
	When LUsuari clica sobre la opcio <article> 
	Then La pagina mostra <article> 
	
	Examples:
	|article|
	|Tablets|
	#|Software| 
	#|Cameras|
	
	#escenari 3: accedir a les categories amb menus desplegables
	@tag3
	Scenario: Accedir a les categories del menu desplegables
	    
	Given LUsuari entra a la pagina principal de OpenCart
	When LUsuari clica sobre la opcio <article>
	Then Mostra les opcions del menu desplegabla de la categoria <numero>
	
	Examples:
	|article | numero |
	|Desktops| 1 |
	#|Laptops & Notebooks| 2 |
	#|Components| 3 |
	#|MP3 Players| 4 |
	
	  
	#escenari 4: Si es fa click a un producte a la pagina principal que es mostri la descripcio
	@tag4
	Scenario: Seleccio producte pagina principal
	
	Given LUsuari entra a la pagina principal de OpenCart
 	When LUsuari clica sobre la opcio <article>
  Then Es mostra el producte <article> amb detalls i preu
  
	  Examples:
 	| article         | 
  | MacBook          | 
  | iPhone           |    
  #| Apple Cinema 30" | 
  #| Canon EOS 5D     | 
	
  #escenari 5: verificar que es pot fer el canvi de moneda 
  @tag5
  Scenario: Canvi de moneda
  
  Given LUsuari entra a la pagina principal de OpenCart
 	When El client pren sobre la moneda al header
 	And LUsuari canvia el tipus de moneda a <opcio>
  Then Es mostren els productes amb el tipus de moneda <simbol> corresponent
  	 
  Examples:
 	| opcio           | simbol |
  | € Euro          | €      |
  | £ Pound Sterling| £      |
  #| $ US Dollar     | $      |
   
  
  #escenari 6: verificar que es pot buscar un producte al buscador 
  @tag6
  Scenario: Verificar que es pot buscar al buscador
  
  Given LUsuari entra a la pagina principal de OpenCart
 	When LUsuari escriu <opcio> al buscador
 	And LUsuari confirma lopcio
  Then Es mostra o no els productes buscats <opcio>
  	 
  Examples:
 	| opcio  | 
  | iPhone | 
  | Dress  |
  | 454    |


 
  
 
