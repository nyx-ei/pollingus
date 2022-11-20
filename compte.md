# Configurez un compte Meta basé sur les informations d'identification NYX-EI et capable d'utiliser le webhook

## step 1
- creer un compte meta sur https://developers.facebook.com/ et acceder à l'interface de developpement de Facebook 

## step 2

- on cree une application au niveau de cette interface
-  on choisis le type d'application
-  on lui donne un nom et on ajoute une email valide 
-  on clique sur **CREATE APP** puis vous aurez à entrer votre mot de passe facebook pour valider la création de l'application et accéder à l'interface de developpement de facebook

## step 3

- rendu au niveau de l'interface en question vous avez la possibilité de choisir l'application que vous souhaitez implementer dans votre API
- cliquez sur **SETUP** de Whatsapp et accéder à l'interface de paramétrage 
- l'API vous offre un token d'accès ou jeton temporaire et un numéro de test pour l'envoi des messsages 

## step 4 

- envoi des message par l'API
- Pour envoyer un message de test, copiez cette commande, collez-la dans Terminal, et cliquez sur Entrée. 
- commande qui correspond au parametrage de l'envoi des messsages : curl -i -X POST `
  https://graph.facebook.com/v15.0/102939389315673/messages `
  -H 'Authorization: Bearer EAAHwzYXQEZAQBAFXaC53RXGZCoyW1w1JrZA1XcKBjFoJO5h3DNIQzf2LR2RZCs9t5gek9LnEanwyrZBEZBej9VswvgFdoS4ZALJownmZB75iIeJvRLKM2uiU1BEs6ZCohIUQvlAVB0MVbwilUey3GXfCcAWCCTp6CCgHOBRWzDji60o4pz2ubBXcvcivKocrlUTxCpHds6Aea5gZDZD' `
  -H 'Content-Type: application/json' `
  -d '{ "messaging_product": "whatsapp", "to": "694219581", "type": "template", "template": { "name": 
"hello_world", "language": { "code": "en_US" } } }'
- si vous verifiez votre whatsapp vous verrez effectivement apparaitre le sms de test... message qui est biensûr personnalisable en fonction de contexte.


## step 5 

- ajouter son numéro de téléphone business pour commencer à envoyer des messages à n’importe quel numéro WhatsApp à partir du numéro ajouté.
- cliquez sur **ADD PHONE NUMBER** puis rajouter les informations neccesaires telles que 
#### infos
- [ ] Nom à l’écran du profil WhatsApp Business
- [ ] Fuseau horaire
- [ ] Cathégorie
- [ ] Numéro de téléphone avec on indicatif et vous recevez un message pour vérifier si le numéro est vraiment le votre 

## step 6

- créer des modèles de messages 
- cliquez sur **ICI** juste en dessus du message de configuration par défaut et vous serrez rediriger sur une autre page pour créer votre propre modele selon vos besoins vous pouvez ajouter
#### contenu
- [ ] un titre
- [ ] corps ( message prpoprement dit )
- [ ] un pied de page ( avec le nom de votre entreprise )
- [ ] des bouttons qui permettent aux clients de repondre à votre message ou d'effectuer une action ils peuvent permettre par exemple 
#### reponse
-  un reponse rapide soit par oui ou non
-  d'effectuer un appel vers un numéro
-  d"être rediriger vers un site internet

## step 7

 - Configurez webhooks pour recevoir des messages
 - definir une URL de rappel pour les demandes de validations et les notifications webhook
 - verifier le token que vous renverra facebook dans le cadre de la vérification de l'URL de rappel 

 
