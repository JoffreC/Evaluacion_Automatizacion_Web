@testProductoTienda
Feature: Product - Store
  @loginTienda
  Scenario Outline: Validacion del precio de un producto
    Given esoy en la pagina de la tienda
    And me logueo con mi usuario "<usuario>" y clave "<clave>"
    When navego a la categoria "<category>" y subcategoria "<subcategory>"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmacion del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito
    Examples:
      | usuario                     | clave      | category | subcategory |
      | joffrecondor747@outlook.com | Joffre747@ | Clothes  | Men         |
      | joffrecondor747outlook.com  | Joffre747@ | Clothes  | Men         |
      | joffrecondor747@outlook.com | Joffre747@ | Cars     | Sport       |


