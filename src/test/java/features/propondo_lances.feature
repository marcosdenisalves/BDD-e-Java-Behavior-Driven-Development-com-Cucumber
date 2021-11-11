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