# Kata GildedRose  #
## Code Smells identificados ##
- (Magic Numbers) Existen valores "hard-coded" que se utilizan muchas veces
  - No deja en claro su proposito por lo que complica la lectura del codigo
  - Puede complicar el mantenimiento en caso de que el valor cambie 
- Anidacion de if's que causa que el codigo sea dificil de leer y mantener
  - Ademas de anidacion innecesaria debido a que muchos ifs podian juntarse
  - Muchos ifs no tenian un proposito
- Codigo que no tiene un proposito o que puede ser un error: items.get(i).getQuality() - items.get(i).getQuality()
- Uso de un for en vez de un foreach siendo que el indice solo es usado para obtener el elemento actual
- La clase Item muestra problemas de encapsulacion 
## Principios no respetados ##
- SRP - la funcion updateQuality se encarga de actualizar la calidad de todos los tipos de items
- OCP - para poder agregar nuevos tipos de items es necesario modificar el codigo existente  

## Bitacora de cambios ##
- Limpieza inicial code smells y reduccion de complejidad 
- Separar logica de cada tipo de item
  - QualityUpdater para cada tipo de item
  - QualityUpdaterFactory singleton que retorna la instancia adecuada para el tipo de item
  