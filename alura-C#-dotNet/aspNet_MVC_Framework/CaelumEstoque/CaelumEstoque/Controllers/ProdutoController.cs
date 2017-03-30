using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using CaelumEstoque.DAO;
using CaelumEstoque.Models;

namespace CaelumEstoque.Controllers
{
    public class ProdutoController : Controller
    {
        // GET: Produto
        [Route("produtos", Name = "ListaProdutos")]
        public ActionResult Index()
        {
            ProdutosDAO dao = new ProdutosDAO();
            IList<Produto> produtos = dao.Lista();
            //ViewBag.Produtos = produtos;
            return View(produtos);
        }

        public ActionResult Form()
        {
            CategoriasDAO dao = new CategoriasDAO();
            IList<CategoriaDoProduto> categorias = dao.Lista();
            ViewBag.Categorias = categorias;
            ViewBag.Produto = new Produto();
            return View();
        }

        [HttpPost]
        public ActionResult Adiciona(Produto produto)
        {
            int idDaInformatica = 1;
            if(produto.CategoriaId.Equals(idDaInformatica) && produto.Preco < 100)
            {
                ModelState.AddModelError("produto.Invalido", "Informática com preço abaixo de 100 reais");
            }

            if (ModelState.IsValid)
            {
                ProdutosDAO dao = new ProdutosDAO();
                dao.Adiciona(produto);

                return RedirectToAction("Index", "Produto");
            } else
            {
                ViewBag.Produto = produto;
                CategoriasDAO dao = new CategoriasDAO();
                ViewBag.Categorias = dao.Lista();
                return RedirectToAction("Form");
            }
        }

        [Route("produtos/{id}", Name = "VisualizaProduto")]
        public ActionResult Visualiza(int id)
        {
            ProdutosDAO dao = new ProdutosDAO();
            Produto produto = dao.BuscaPorId(id);
            ViewBag.Produto = produto;
            return View();
        }

        public ActionResult DecrementaQtd(int id)
        {
            ProdutosDAO dao = new ProdutosDAO();
            Produto p = dao.BuscaPorId(id);
            p.Quantidade--;
            dao.Atualiza(p);
            return Json(p);
        }
    }
}