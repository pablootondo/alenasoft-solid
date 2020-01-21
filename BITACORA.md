# Kata GildedRose  #
## Code Smells identificados ##
- (Magic Numbers) Existen valores _hard-coded_ que se utilizan muchas veces
  - No deja en claro su proposito por lo que complica la lectura del codigo
  - Puede complicar el mantenimiento en caso de que el valor cambie 
- Anidacion de _ifs_ que causa que el codigo sea dificil de leer y mantener
  - Ademas de anidacion innecesaria debido a que muchos _ifs_ podian juntarse
  - Muchos ifs no tenian un proposito
- Codigo que no tiene un proposito o que puede ser un error: **items.get(i).getQuality() - items.get(i).getQuality()**
- Uso de un _for_ en vez de un _foreach_ siendo que el indice solo es usado para obtener el elemento actual
- La clase Item muestra problemas de encapsulacion 
## Principios no respetados ##
- SRP - la funcion **updateQuality** se encarga de actualizar la calidad de todos los tipos de items
- OCP - para poder agregar nuevos tipos de items es necesario modificar el codigo existente  

## Bitacora de cambios ##
- Limpieza inicial code smells y reduccion de complejidad 
- Separar logica de cada tipo de item
  - **QualityUpdater** para cada tipo de item
  - **QualityUpdaterFactory** singleton que retorna la instancia de **QualityUpdater** adecuada para el tipo de item
- Add Conjured item feature
  