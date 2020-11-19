# REST Lab Exercise

## Revise Fibonacci Web Service

- Fibonacci Web Service adjusted
- Fibonacci Test adjusted

## Create a RESTful version ob the Continuous Fibonacci Web Service

### Sketch the design

- 2 Ideen
    - Fibonacci als Collection von Ressourcen
    - Fibonacci als einzelne Ressource ✔
- Fibonacci ist eine einzelne Ressource, welche mittels HTTP-Operationen verändert/ausgelesen werden kann
- Ressource speichert n [und optional fibonacci(n)]
- Initialzustand 1
- MIME-Type: application/json [wir geben ein Objekt bestehend aus n und fibonacci(n) zurück]
- HTTP-Operationen:
    - POST: Update der aktuellen Ressource (n), da next() nicht idempotent und nicht safe --> POST
    - GET: Auslesen der aktuellen Fibonacci Zahl, da GET idempotent und safe sein muss
    - DELETE: Repräsentation von restore() --> setzt Ressource auf Initialzustand zurück --> Passt zu Idempotenz und Safety

### Implement your design

- 