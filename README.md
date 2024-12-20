# 钉钉书店移动App项目 README

## 项目概述

钉钉书店是一款基于uni-app框架和Spring Boot后端技术的移动应用项目。该项目旨在为用户提供一个便捷、全面的在线书店平台，让用户能够轻松浏览、搜索、购买并阅读各类电子书籍。

## 技术栈

- **前端**：uni-app（支持多平台开发，包括iOS、Android、H5等）
- **后端**：Spring Boot（提供RESTful API接口，处理业务逻辑）
- **数据库**：MySQL（存储用户、图书、订单等数据）

## 项目结构

### 前端（uni-app）

- **页面**：包括首页、图书分类页、图书详情页、购物车页、订单页、个人中心页等。
- **组件**：封装了常用的UI组件，如导航栏、搜索框、轮播图等。
- **API接口**：与后端进行数据交互，获取用户信息、图书列表、订单详情等数据。

### 后端（Spring Boot）

- **Controller层**：负责接收前端请求，调用Service层处理业务逻辑，并返回结果。
- **Service层**：处理具体的业务逻辑，如用户注册登录、图书查询、订单生成等。
- **Mapper层**：与数据库进行交互，执行CRUD操作。
- **实体类**：对应数据库中的表结构，封装数据。

## 功能模块

1. **用户模块**：支持用户注册、登录、个人信息修改、密码重置等功能。
2. **图书模块**：提供图书分类浏览、搜索、详情查看、购买等功能。
3. **购物车模块**：支持添加、删除、修改商品数量等操作。
4. **订单模块**：支持订单创建、查询、支付等功能。
5. **阅读模块**：提供电子书在线阅读功能，支持书签、进度条等。

## 开发环境配置

- **前端**：
  - 安装HBuilderX或VS Code等编辑器。
  - 安装Node.js和npm，用于构建和运行uni-app项目。
- **后端**：
  - 安装JDK和Maven，用于构建和运行Spring Boot项目。
  - 安装MySQL数据库，并导入项目所需的数据库脚本。

## 运行指南

### 前端

1. 克隆项目仓库到本地。
2. 使用HBuilderX或VS Code打开项目。
3. 安装项目依赖：`npm install`。
4. 运行项目：在编辑器中选择运行或调试选项，选择目标平台（如H5、小程序、App等）。

### 后端

1. 克隆后端仓库到本地。
2. 使用IDE（如IntelliJ IDEA或Eclipse）打开项目。
3. 配置数据库连接信息（在`application.properties`或`application.yml`文件中）。
4. 运行Spring Boot应用：在IDE中右键点击主类并选择“Run”选项，或使用Maven命令`mvn spring-boot:run`。
5. 访问后端API接口：使用Postman或类似工具测试API接口是否正常工作。

## 注意事项

- 在开发过程中，请确保前端和后端项目处于同一网络环境下，以便进行联调测试。
- 在部署生产环境时，请对后端接口进行安全防护（如使用HTTPS、限制IP访问等）。
- 请根据实际需求对数据库进行备份和优化操作。
