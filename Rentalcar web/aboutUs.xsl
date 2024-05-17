<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Opiniones</title>
				<style>
                     body {
                        font-family: Arial, sans-serif;
                        margin: 0;
                        padding: 0;
                    }

                    h1 {
                        text-align: center;
                        font-size: 36px;
                        margin-top: 20px;
                    }

                    .team-list {
                        list-style-type: none;
                        padding: 0;
                        display: flex;
                        flex-wrap: wrap;
                        justify-content: center;
                    }

                    
					
	.team-member {
    width: 400px; /* Aumentamos el ancho de las cajas */
    margin: 20px auto 5px; /* Reducimos el margen inferior de las cajas */
    background-color: lightblue;
    padding: 20px;
    text-align: center;
    border-radius: 15px;
    box-sizing: border-box;
}

.footer {
    margin-top: 10px; /* Reducimos el margen superior del footer */
}

.contendorIMG {
    margin-bottom: 10px; /* Reducimos el margen inferior del contenido principal */
    padding-bottom: 20px; /* Añadimos un padding en la parte inferior para reducir el espacio con el footer */
}


                    .team-member img {
                        width: 150px;
                        height: 150px;
                        border-radius: 50%;
                        margin-bottom: 10px;
                    }

                    .team-member strong {
                        display: block;
                        font-weight: bold;
                        margin-bottom: 10px;
                        font-size: 20px;
                    }

                    .team-member p {
                        font-size: 16px;
                    }
					
					.contendorIMG {
    margin-bottom: 0; /* Reducir el margen inferior del contenedor principal */
    padding-bottom: 20px; /* Añadir un relleno inferior para crear espacio entre el contenido y el pie de página */
}

.footer {
    margin-top: 0; /* Reducir el margen superior del pie de página */
}

					
                </style>
            </head>
            <body>
                <h1>Opiniones</h1>
                <ul class="team-list">
                    <xsl:apply-templates select="peticion/persona"/>
                </ul>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="persona">
        <li class="team-member">
            <img src="{imagen}" alt=""/>
            <strong><xsl:value-of select="nombre"/></strong>
            <p><xsl:value-of select="opinion"/></p>
        </li>
    </xsl:template>
</xsl:stylesheet>