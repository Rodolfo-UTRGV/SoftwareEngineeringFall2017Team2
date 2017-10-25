<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
version="1.0">
<xsl:output method="xml" indent="yes"/>
<xsl:template match="/">
<html>
<head><title>VaQNutritionSystem In Action</title></head>
<body style="background:#D3D3D3">
<p>VaQNutri In Action </p>
<p>Personal Information</p>
<center> 
<h1 style="background-color: #d0e4fe">Nutritional Facts</h1>
<h2>Recommended By the NIH</h2> 
<h2>DC, USA</h2>
<img src="smt.png" alt="SMT College" style="width:100;height:100;"> </img>
 </center> 

<p>Nutrition Facts</p>
<table align="center" border="1">
<tr>
<th>Name</th>
<th>Calories</th>
<th>Fats</th>
<th>Sugars</th>
<th>Carbs</th>
<th>Proteins</th>
</tr>
<xsl:for-each select="NutritionFacts/NutrientComponent">
<tr>
<td><h3 style="background-color:red;color:blue"> <xsl:value-of select="name"/></h3></td>
<td><xsl:value-of select="calories"/></td>
<td><xsl:value-of select="fat"/></td>
<td><xsl:value-of select="sugar"/></td>
<td><xsl:value-of select="carbs"/></td>
<td><xsl:value-of select="protein"/></td>
</tr>
</xsl:for-each>
</table>
</body></html>
</xsl:template>
</xsl:stylesheet>