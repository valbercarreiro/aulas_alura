﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CaelumEstoque.Controllers
{
    public class ContadorController : Controller
    {
        // GET: Contador
        public ActionResult Index()
        {
            object valorNaSessao = Session["contador"];
            int contador = Convert.ToInt32(valorNaSessao);
            contador++;
            Session["contador"] = contador;
            return View(contador);
        }
    }
}