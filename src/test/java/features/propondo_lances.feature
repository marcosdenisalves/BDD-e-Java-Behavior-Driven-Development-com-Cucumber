# language: pt

Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um unico lance valido
 Dado um lance valido
 Quando proposto
 Entao o lance e aceito
 
Cenario: Propondo varios lances validos
 Dado um lance de 10.0 reais do usuario "fulano"
 E um lance de 15.0 reais do usuario "beltrano"
 Quando forem propostos varios lances
 Entao os lances sao aceitos
 
Esquema do Cenario: Propondo um lance invalido
 Dado um lance invalido de <valor> reais e do usuario '<nomeUsuario>'
 Quando proposto
 Entao o lance nao e aceito
 
Exemplos:
	| valor | nomeUsuario |
	|			0 | beltrano 		|
	|			-1| cicrano			|
	
Cenario: Propondo uma sequencia de lances
 Dado dois lances
	| valor | nomeUsuario |
	|	 10.0 | beltrano 		|
	|	 15.0 | beltrano			|
 Quando forem propostos varios lances
 Entao o segundo lance nao e aceito