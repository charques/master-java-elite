<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Agenda</h2>

				<xsl:for-each select="agenda/contacto">
					<b><xsl:value-of select="nombre" /></b>
					<br />
					<xsl:value-of select="direccion" />, <xsl:value-of select="localidad" />, <xsl:value-of select="cp" />, <xsl:value-of select="pais" />
					<br />
					<xsl:value-of select="email" />
					<br />
					<xsl:value-of select="telefono" />
					<br /><br /><b>Citas</b><br />
					<table border="1">
						<tr bgcolor="#DCDCDC">
							<th>Descripcion</th>
							<th>Fecha</th>
							<th>Hora inicio</th>
							<th>Duración (min)</th>
						</tr>
						<xsl:for-each select="cita">
							<tr>
								<td>
									<xsl:value-of select="descripcion" />
								</td>
								<td>
									<xsl:value-of select="fecha" />
								</td>
								<td>
									<xsl:value-of select="horaInicio" />
								</td>
								<td>
									<xsl:value-of select="duracion" />
								</td>
							</tr>
						</xsl:for-each>
					</table>
					<br />
					<hr />
					<br />
				</xsl:for-each>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
