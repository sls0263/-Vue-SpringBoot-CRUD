import { createWebHistory, createRouter } from "vue-router";
import Home from "../components/Home";

import Form from "../common/menu";
// import Login from "../common/login";

import NotFound from "../components/NotFound";

import ExamGrid from "../view/EmployInfo";

const routes = [
  // {
  //   path: "/",
  //   name: "Login",
  //   component: Login
  // }
  ,{
    path: "/",
    name: "Home",
    component: Home
  }
  ,{
    path: "/menu",
    name: "menu",
    component: Form
  }
  ,{
    path: "/notFound",
    name: "notFound",
    component: NotFound
  }
  ,{
    path: "/EmployInfo",
    name: "EmployInfo",
    component: ExamGrid
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
