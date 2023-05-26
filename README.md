# calculadoraBackend
Proyecto backend calculadora inversión

1.- Para correr el proyecto de manera local escriba esta ruta -> cd calculadorainversiones

2.- Ejecute el comando mvn spring-boot:run

3.- Si se prueba en postman, la ruta del servicio es la siguiente: http://localhost:8080/calculadora/inversion

4.- El json a enviar es el siguiente

{
    "inversionInicial": 5000 ,
    "aportacionAnual": 3000 ,
    "porcentajeIncrementoAnual": 1 ,
    "aniosInversion": 5 ,
    "rendimientoInversion": 21
}