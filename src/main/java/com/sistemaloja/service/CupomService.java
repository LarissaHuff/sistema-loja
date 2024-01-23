package com.sistemaloja.service;

import com.sistemaloja.dto.CupomDTO;
import com.sistemaloja.dto.CupomViewDTO;
import com.sistemaloja.enumeration.TipoDesconto;
import com.sistemaloja.model.Cupom;
import com.sistemaloja.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CupomService {
    @Autowired
    CupomRepository cupomRepository;

    public void cadastrar(CupomDTO dto) {
        Cupom cupom = new Cupom();
        cupom.setValor(dto.valor());
        cupom.setCodigo(dto.codigo());
        cupom.setTipoDesconto(dto.tipoDesconto());
        cupom.setValorMinimoDaCompra(dto.valorMinimoDaCompra());
        cupom.setQuantidade(dto.quantidade());
        cupom.setDataExpiracao(dto.dataExpiracao());
        cupom.setAtivo(dto.ativo());

        cupomRepository.save(cupom);

    }

    public CupomViewDTO findById(Long id) {
        return new CupomViewDTO(cupomRepository.findById(id).orElseThrow());
    }

    public void desativaById(Long id) {

        Cupom cupom = cupomRepository.findById(id).orElseThrow();
        LocalDate agora = LocalDate.now();

        if (agora.isAfter(cupom.getDataExpiracao())) {
            cupom.setAtivo(false);
            cupomRepository.save(cupom);
        }
    }

    public void desativa() {

        List<Cupom> cupons = cupomRepository.findAll();
        LocalDate agora = LocalDate.now();

        for (int i = 0; i < cupons.size(); i++) {
            if (agora.isAfter(cupons.get(i).getDataExpiracao())) {
                cupons.get(i).setAtivo(false);

            }
            cupomRepository.saveAll(cupons);
        }
    }

    public void desativaStream() {
        LocalDate agora = LocalDate.now();

        List<Cupom> cupons = cupomRepository.findAll();
        List<Cupom> cupomList = cupons.stream()
                .filter(it -> it.getDataExpiracao().isAfter(agora) && it.getAtivo())
                .map(CupomService::desativar)
                .toList();

        cupomRepository.saveAll(cupomList);

    }

    private static Cupom desativar(Cupom it) {
        it.setAtivo(false);
        return it;
    }


    public Cupom findByCodigo(String codigo) {
        return cupomRepository.findByCodigo(codigo).orElseThrow();
    }

    public Integer aplicarDesconto(Integer valorCompra, Cupom cupom) {
        if (valorCompra < cupom.getValorMinimoDaCompra()) {
            throw new RuntimeException("valorCompra minimo da compra não atingido para aplicar cupom.");

        }
        Integer valorTotal = 0;
        TipoDesconto tipoDesconto = cupom.getTipoDesconto();

        switch (tipoDesconto) {
            case DIRETO -> valorTotal = valorCompra - cupom.getValor();
            case PORCENTAGEM -> valorTotal = valorCompra - getValorPorcentagem(valorCompra, cupom.getValor());
        }

        return valorTotal;
    }

    private Integer getValorPorcentagem(Integer valorCompra, Integer porcentagem) {
        return (porcentagem / 100) * valorCompra;
    }
}

