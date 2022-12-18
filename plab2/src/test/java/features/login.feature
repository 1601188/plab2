
Feature: Login OpenCart

	#escenari 1: login d'un usuari creat
  @tag1
  Scenario: Login Usuari
  
  Given Pagina principal de OpenCart
 	When LUsuari clica a la opcio de Login
  And LUsuari fica <email> <password> 
  And LUsuari clica al boto login
  Then LUsuari fa login correctament
  
  Examples:
 	| email             | password   |
  | exemple@gmail.com | exemple111 |
  
  
  #escenari 2: Un usuari fa logout 
  @tag2
  Scenario: LoGout Usuari
  
	Given Pagina principal de OpenCart
 	When LUsuari clica a la opcio de Login
  And LUsuari fica <email> <password> 
  And LUsuari clica al boto login
  And LUsuari fa login correctament
  And LUsuari vol tancar sessio i clica al boto LogOut 
  Then Sha de tancar la sessio del Usuari
  
	  Examples:
 	| email             | password   |
  | exemple@gmail.com | exemple111 |
  
  #escenari 3: verificar que es pot recuperar la contrasenya oblidada
  @tag3
  Scenario: Login Usuari contrasenya oblidaada
  
  Given Pagina principal de OpenCart
 	When LUsuari clica a la opcio de Login
  And LUsuari fica <email> <password> 
  And LUsuari clica al boto login
  Then Se li avisa de que la contrasenya es incorrecta
  When LUsuari clica a recuperar la contrasenya
  And LUsuari escriu el seu correu <email>
  Then Se li confirma que ha rebut un correu per recuperar la contrasenya
  
  Examples:
 	| email             | password   |
  | exemple@gmail.com | exemple |
  
