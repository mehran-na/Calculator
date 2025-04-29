# Calculatrice

Une calculatrice simple en Java qui permet d'évaluer des expressions mathématiques.

## Description

Ce projet permet de calculer des expressions mathématiques en utilisant les opérations de base : addition (`+`), soustraction (`-`), multiplication (`*`) et division (`/`). Il prend en charge la priorité des opérations et peut gérer des expressions comme `3 + 4 * 2`, respectant l'ordre des opérations (PEMDAS).

Le projet est composé de plusieurs classes qui se chargent chacune d'une partie du processus :

1. **App** : La classe principale qui gère l'entrée de l'utilisateur et affiche le résultat.
2. **Tokenizer** : La classe qui divise l'expression en une liste de tokens (numéros et opérateurs).
3. **Evaluator** : La classe qui évalue la liste de tokens et effectue les calculs.
4. **InputValidator** : La classe qui valide les entrées de l'utilisateur pour s'assurer qu'elles sont correctes.
5. **Operator** : L'énumération qui représente les différents opérateurs mathématiques.
6. **Token** : La classe qui représente un token (un nombre ou un opérateur) dans l'expression.

## Fonctionnalités

- Prise en charge des opérations de base : addition, soustraction, multiplication et division.
- Respect de la priorité des opérations (multiplication/division avant addition/soustraction).
- Validation des entrées pour s'assurer qu'elles ne contiennent que des chiffres, des opérateurs ou des espaces valides.
- Gestion des erreurs comme la division par zéro et les entrées invalides.