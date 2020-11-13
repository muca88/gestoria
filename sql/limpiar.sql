delete [Gestoria].[dbo].[AlojamientoDocumentos]
DBCC CHECKIDENT ('[Gestoria].[dbo].[AlojamientoDocumentos]', RESEED, 0)
delete [Gestoria].[dbo].[DocumentosPermiso]
DBCC CHECKIDENT ('[Gestoria].[dbo].[DocumentosPermiso]', RESEED, 0)
delete [Gestoria].[dbo].[Permisos]
DBCC CHECKIDENT ('[Gestoria].[dbo].[Permisos]', RESEED, 0)
delete [Gestoria].[dbo].[Solicitudes]
DBCC CHECKIDENT ('[Gestoria].[dbo].[Solicitudes]', RESEED, 0)