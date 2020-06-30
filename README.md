# Examen DAWII 2 - Renzo

Este aplicativo esta hecho con el ecosistema Spring:

- Spring Boot
- Thymeleaf
- MySQL

# Links Publicos

  - Aplicativo: https://dawii-cl2-renzo.herokuapp.com/

### Instalacion

Exporte este repositorio a IntelliJ IDEA o Eclipse.

- ##### Data Incial de tablas

Al correr por primera vez el aplicativo, un script llamado data.sql ubicado en src/main/resources sera ejecutado.

Se recomienda desactivar una opcion en application.properties para evitar problemas de "primary key" 

```properties
spring.datasource.initialization-mode=never
```

### Observaciones

He notado un bajo performance con una atributo de Thymeleaf "th:field" y "select,option":

``` html

<select th:field="*{object}" class="form-control" id="object" name="object">
                <option th:each="obj:${listObj}" th:value="${obj.id}" th:text="${obj.nombre}"/>
</select>

```

Al usar un servidor MySQL remoto, he notado un alto tiempo de espera del servidor, investige por mi cuenta y encontre una solucion:

Borro el atributo "th:field" de select y declaro una operacion ternaria en todas las options que se van a renderizar.

Si el objeto esta vacio, todos las opciones seran vacias, ya que este objeto es nuevo. Pero, si el objeto tiene data (Si se va a editar o es devuelta de un error de formulario) este se va a comparar con toda la listas de id`s. Asi dejando seleccionado su respectivo valor.

``` html

<select class="form-control" id="object" name="object">
                <option th:each="obj:${listObj}" th:selected="*{object != null} ? *{object.id} == ${obj.id} : false" th:value="${obj.id}" th:text="${obj.nombre}"/>
</select>

```
