<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- para meter los códigos con el símbolo del dolar -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!-- para mostrar monedas -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${titulo}</title>
<c:set var="ruta" value="${pageContext.request.contextPath}" scope="request"/>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="${path}/static/js/pizzas.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


</head>
<body>
	<h2>LISTADO DE PIZZAS</h2>

	<h2>${titulo}</h2>

	<div>
		<table
			class="table table-hover table-condensed table-striped table-bordered">
			<thead>
				<tr>
					<td style="width: 10%">#</td>
					<td style="width: 35%">Nombre</td>
					<td style="width: 20%">Categoria</td>
					<td style="width: 15%">Precio</td>
					<td style="width: 10%">Editar</td>
					<td style="width: 10%">Borrar</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pizzas}" var="pizzas">
					<tr data-id="${pizzas.id}">
						<td>${pizzas.id}</td>
						<td>${pizzas.nombre}</td>
						<td>${pizzas.categoria}</td>
						<td>${pizzas.precio}</td>
						<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
						<td><button type="button" class="btn btn-danger btn-borrar">Borrar</button></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">Pizza Añadir: <span
						id="cantidad-pizzas">${pizzas.size()}</span></td>
				</tr>
				<tr>
					<td colspan="5">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#modal-ingrediente">Añadir Pizza</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>

	<div class="modal fade" id="modal-pizza" tabindex="-1" role="dialog"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="form-pizzas" method="post">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title">Crear una pizza</h4>
                    </div>
                    <div class="modal-body">
                        <label for="nombre">Nombre: </label> <input id="nombre"
                            name="nombre" class="form-control">
                        <label for="precio">Precio:</label>
                        <input id="precio" name="precio" class="form-control"> <label
                            for="categoria">Categoria: </label> <select id="categoria"
                            name="categoria" class="form-control">
                            <c:forEach items="${categorias}" var="categoria">
                                <option value="${categoria}">${categoria}</option>
                            </c:forEach>
                        </select> <label for="ingredientes">Ingredientes: </label> <select
                            id="ingredientes" name="ingredientes" class="form-control"
                            multiple="multiple">
                            <c:forEach items="${ingredientes}" var="ingrediente">
                                <option value="${ingrediente}">${ingrediente.nombre}</option>
                            </c:forEach>
                        </select> <input id="id" name="id" type="hidden"> <input id="csrf"
                            name="_csrf" type="hidden" value="${_csrf.token}">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        <button id="btn-salvar" type="submit" class="btn btn-primary">Guardar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
	

	
</body>
</html>