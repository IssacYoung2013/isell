<html>
<#include "../common/header.ftl">
<body>

<div id="wrapper" class="toggled">

<#--边栏-->
    <#include "../common/nav.ftl">
<#--主要内容区域-->
    <div id="page-content-wrapper">

        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/isell/seller/category/save">
                        <div class="form-group">
                            <label for="categoryName">名字</label>
                            <input type="text" class="form-control" name="categoryName"
                                   value="${(category.categoryName)!""}"/>
                        </div>
                        <div class="form-group">
                            <label for="categoryType">类型</label>
                            <input type="number" class="form-control" name="categoryType"
                                   value="${(category.categoryType)!""}"/>
                        </div>

                        <input type="hidden" name="categoryId" value="${(category.categoryId)!"" }">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>