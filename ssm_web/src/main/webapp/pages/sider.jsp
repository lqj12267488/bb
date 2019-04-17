<%--
  Created by IntelliJ IDEA.
  User: wyan
  Date: 2018/12/27
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!-- 导航侧栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="./img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>张猿猿</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- search form -->
        <!--<form action="#" method="get" class="sidebar-form">
    <div class="input-group">
        <input type="text" name="q" class="form-control" placeholder="搜索...">
        <span class="input-group-btn">
        <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
        </button>
      </span>
    </div>
</form>-->
        <!-- /.search form -->


        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>




            <li class="treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>数据管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="travellog-manage">
                        <a href="${pageContext.request.contextPath}/product/findAll?pageNum=1&pageSize=3">
                            <i class="fa fa-circle-o"></i> 产品列表
                        </a>
                    </li>

                    <li id="travellog-review">
                        <a href="${pageContext.request.contextPath}/order/find?pageNum=1&pageSize=3">
                            <i class="fa fa-circle-o"></i> 订单列表
                        </a>
                    </li>



                </ul>
            </li>

            <security:authorize access="hasRole('ROLE_ADMIN')">

            <li class="treeview">


                <a href="#">
                    <i class="fa fa-cogs"></i> <span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="system-setting">
                        <a href="${pageContext.request.contextPath}/user/findAllUser?pageNum=1&pageSize=3">
                            <i class="fa fa-circle-o"></i> 用户列表
                        </a>
                    </li>
                    <li id="system-setting1">
                        <a href="${pageContext.request.contextPath}/role/findAll">
                            <i class="fa fa-circle-o"></i> 角色列表
                        </a>
                    </li>

                </ul>
            </li>
            </security:authorize>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<!-- 导航侧栏 /-->