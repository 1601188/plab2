Feature: Opcions peu de pagina

	#escenari 1: verificar que es pot accedir a les opcions d'informacio del peu de pagina
	@tag1
	Scenario: LUsuari clica a una de les opcions de informacio de la web
	Given Pagina principal de la web
	When LUsuari clica sobre una opcio dinformacio <opcio>
	Then  Se li ha de mostra la pagina amb linformacio <opcio> on ha clicat
		
	Examples:
	|opcio|
	|About Us|
  |Delivery Information|
  |Privacy Policy|
  |Terms & Conditions|

	#escenari 2: verificar que un usuari pot contactar amb lempresa
	@tag2
	Scenario: LUsuari vol contactar amb lempresa
	    
	Given Pagina principal de la web
	When LUsuari clica sobre una opcio dinformacio <opcio>
	Then Se li mostra el formulari
	And LUsuari emplena les dades <enquiry> <email> <nom>
	And Clica al boto per enviar les dades
	Then Senvien les dades correctament
	
	Examples:
	|nom| email | enquiry | opcio |
	|Laura| exemple@gmail.com| Tinc problemes amb un dels productes comprats| Contact Us |


	#escenari 3: verificar que es pot accedir a la pagina de devolucio desde lopcio
	#del footer i emplenar el formulari i enviar
	@tag3
	Scenario: Devolucio del producte desde lopcio del footter
	    
	Given Pagina principal de la web
	When LUsuari clica sobre una opcio dinformacio <opcio>
	Then Es mostra el formulari de devolucio 
	And El client inserta les dades <details> <nom> <cognom> <correu> <tlf> <orderid> <prodname> <prodcode> 
	And Confirmar les dades
	Then Confirmacio denviament
	
	Examples:
	| opcio   | nom   | cognom   | correu            | tlf       | orderid | prodname | prodcode | details |
	| Returns | Laura | Gomez    | exemple@gmail.com | 655666555 | 223     |iPhone    | 11       | Producte en mal estat i no funcional |


