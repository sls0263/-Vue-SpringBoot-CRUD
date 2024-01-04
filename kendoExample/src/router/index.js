import { createWebHistory, createRouter } from "vue-router";
import Home from "../components/Home";

import Form from "../common/menu";
import MenuMgmt from "../view/MenuMgmt";

import NotFound from "../components/NotFound";

import EmployInfo from "../view/EmployInfo";

const routes = [
  {
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
    component: EmployInfo
  }
  ,{
    path: "/MenuMgmt",
    name: "MenuMgmt",
    component: MenuMgmt
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
