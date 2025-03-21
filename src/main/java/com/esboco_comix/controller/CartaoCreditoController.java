package com.esboco_comix.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.esboco_comix.controller.utils.ServletUtil.*;
import com.esboco_comix.model.entidades.CartaoCredito;
import com.esboco_comix.service.CartaoCreditoService;

public class CartaoCreditoController extends HttpServlet {
    private CartaoCreditoService cartaoCreditoService = new CartaoCreditoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String parametroIdCliente = req.getParameter("idcliente");

            if (parametroIdCliente != null){
                int id = Integer.parseInt(parametroIdCliente);

                retornarRespostaJson(
                    resp,
                    cartaoCreditoService.consultarByIDCliente(id),
                    HttpServletResponse.SC_OK
                );
                return;
            }

        } catch (Exception e) {
            estourarErro(resp, e);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            CartaoCredito cartaoCredito = jsonToObject(req, CartaoCredito.class);
            retornarRespostaJson(
                resp,
                cartaoCreditoService.atualizar(cartaoCredito),
                HttpServletResponse.SC_OK
            );
        } catch (Exception e) {
            estourarErro(resp, e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CartaoCredito cartaoCredito = jsonToObject(req, CartaoCredito.class);
            cartaoCreditoService.deletar(cartaoCredito);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception e) {
            estourarErro(resp, e);
        }
    }
}
