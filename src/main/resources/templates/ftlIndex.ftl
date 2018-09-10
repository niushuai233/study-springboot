This is a ftl page<br>
直接取值<br>
${name}<br>
${age}<br>
${sex}<br>

利用freemaker标签进行取值
<#if name="牛帅">
	niushuai
<#else>
	${name}

</#if>

<#if age="23">
	the age is 23
</#if>
