import { inherit } from "@uirouter/core";

export default class MesaController {
  constructor(mesaService) {
    var vm = this;
    this.name = 'Mesa';
    init();
    function init() {
      mesaService.getMesas().then(function abc(resp) {
        vm.mesas = resp.data;
      });
    }
    vm.apagar = function (id) {
      let c = confirm("Tem certeza que deseja excluir?")
      if (c) {
        mesaService.apagar(id).then(function (resp) {
          init();
          vm.mensagem = resp.data.mensagem;
          vm.codigo = resp.data.codigo;
        })
      }
      return false;
    }
  }
}
MesaController.$inject = ['mesaService'];
