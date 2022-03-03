--PROCEDIMIENTOS FACTURA Y DETALLE DE FACTURA
GO
CREATE PROCEDURE InsertarFactura
@fecha date,
@idC int,
@desc decimal,
@idPago int, 
@ref nvarchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	insert into Factura values (@fecha, @idC, @desc, @idPago, @ref)
END
GO

GO
CREATE PROC BuscarCliente
@id nvarchar(13)
AS
BEGIN
select id_cliente from Clientes where identidad = @id
END
GO

GO
CREATE PROC InsertarDetalle
@fact int, 
@prod int,
@precio decimal(18, 2),
@qty int
AS
BEGIN
insert into [dbo].[Detalle_factura] values (@fact, @prod, @precio, @qty)
END
GO

