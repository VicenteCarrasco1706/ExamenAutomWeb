Feature: Página Store de QALAB

  @QaLabStore
  Scenario: Validación del Precio de un Producto
    Given estoy en la página de la tienda
    And me logueo con mi usuario "carrascovicente88@gmail.com" y clave "s81dhQ3j*"
    When navego a la categoria "Clothes" y subcategoria "Men"
    And agrego "2" unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito
