Use `motortec`;
-- Consulta para obtener la tabla autos  
select idAuto, Matricula, Marca.Nombre as Marca, modelo.Nombre as Modelo, Color
From Auto
inner join modelo on modelo.idModelo = auto.idModelo 
inner join marca on marca.idMarca = modelo.idMarca;  
-- 

-- Consulta para obtener los autos usados
select idAuto, Matricula, Marca.Nombre as Marca, modelo.Nombre as Modelo, Color, Kilometraje
From Auto
inner join modelo on modelo.idModelo = auto.idModelo
inner join marca on marca.idMarca = modelo.idMarca
where Estado = 'Usado';
-- 

-- Consulta para obtener los autos nuevos
select idauto, Matricula, Marca.Nombre as Marca, modelo.Nombre as Modelo, Color
From Auto
inner join modelo on modelo.idModelo = auto.idModelo
inner join marca on marca.idMarca = modelo.idMarca
where Estado = 'Nuevo';
-- 

-- Consulta para obtener ventas al ingresar X nombre de X cliente
SELECT idVenta, concesionario.NombreConcesionario as Concesionario, cliente.Nombre as Cliente, cliente.Primerapellido as Papellido, fechaventa, preciodeventa
FROM Venta
INNER JOIN concesionario ON concesionario.idConcesionario = venta.idConcesionario
INNER JOIN cliente ON cliente.idCliente = venta.idCliente
WHERE cliente.Nombre = '';
-- 

-- Consulta para obtener ventas al ingresar X nombre de X concesionario
SELECT idVenta, concesionario.NombreConcesionario as Concesionario, cliente.Nombre as Cliente, cliente.Primerapellido as Papellido, fechaventa, preciodeventa
FROM Venta
INNER JOIN concesionario ON concesionario.idConcesionario = venta.idConcesionario
INNER JOIN cliente ON cliente.idCliente = venta.idCliente
WHERE Concesionario.NombreConcesionario = '';
--

-- Consulta para obtener la venta más cara.
SELECT DISTINCT idVenta, Cliente.Nombre as Cliente, Cliente.PrimerApellido as Papellido, Cliente.SegundoApellido as Sapellido, PreciodeVenta, FechaVenta
FROM Venta
INNER JOIN Cliente ON Venta.idCliente = Cliente.idCliente
WHERE PreciodeVenta LIKE (SELECT MAX(PreciodeVenta) FROM Venta);
--

-- Consulta para obtener la venta menos cara.
SELECT DISTINCT idVenta, Cliente.Nombre as Cliente, Cliente.PrimerApellido as Papellido, Cliente.SegundoApellido as Sapellido, PreciodeVenta, FechaVenta
FROM Venta
INNER JOIN Cliente ON Venta.idCliente = Cliente.idCliente
WHERE PreciodeVenta IN (SELECT MIN(PreciodeVenta) FROM Venta);
--

-- Consulta para filtrar, obtiene autos por X marca 
select idAuto, Matricula, Marca.Nombre as Marca, modelo.Nombre as Modelo, Color
From Auto
inner join modelo on modelo.idModelo = auto.idModelo
inner join marca on marca.idMarca = modelo.idMarca
where Marca.Nombre = '';
--

-- 	Consulta para filtrar busquedas, obtiene auto al ingresar X marca, Y modelo y Z estado. 
select idAuto, Matricula, modelo.Nombre as Modelo, Marca.Nombre as Marca, Color
From Auto
inner join modelo on modelo.idModelo = auto.idModelo
inner join marca on marca.idMarca = modelo.idMarca 
where Marca.Nombre = '' and Modelo.Nombre = '' and Estado = '';
--

-- Consulta para obtener las reparaciones al ingresar X nombre de mecánico.
SELECT idReparacion, Matricula, Cliente.Nombre AS Cliente, Cliente.PrimerApellido as apellido, Mecanico.Nombre AS Mecanico, Mecanico.PrimerApellido as Mapellido, Taller.Nombre AS Taller, HorasReparando,FechaReparacion
FROM Reparacion
LEFT JOIN Auto ON Reparacion.idAuto = Auto.idAuto
RIGHT JOIN Cliente ON Reparacion.idCliente = Cliente.idCliente
INNER JOIN Mecanico ON Reparacion.idMecanico = Mecanico.idMecanico
INNER JOIN Taller ON Reparacion.idTaller = Taller.idTaller
WHERE Mecanico.Nombre LIKE '% %'
ORDER BY Reparacion.idReparacion;
--




