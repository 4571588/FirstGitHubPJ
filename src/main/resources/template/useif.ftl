--------------if语句的使用----------------
<#if score gte 60 >
    及格
<#elseif score gte 80&&score lte 90>
    良好
<#else >
    优秀
</#if>
--------------空值判断、默认值---------------
${name!"未定义"}
--------------判断值是否存在------------
<#if name??>
name存在
<#else>
name不存在
</#if>
-------------使用list遍历数据--------------
<#list userList as user>
<#if user_has_next>
${user.name}-${user.password}
<#else>
最后一个:${user.name}-${user.password}
</#if>
</#list>
-------------其他内建函数-----------------
${time?string("yyyy-MM-dd")}

${str?substring(0,2)}

${str?last_index_of(",")}

<#list "12,13,14,15"?split(",") as item>
${item}
</#list>