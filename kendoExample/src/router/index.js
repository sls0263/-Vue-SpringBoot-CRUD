import { createWebHistory, createRouter } from "vue-router";
import Home from "../components/Home";

import Form from "../components/Form";

import NotFound from "../components/NotFound";

import ExamGrid from "../view/EmployInfo";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  }
  ,{
    path: "/Form",
    name: "Form",
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
