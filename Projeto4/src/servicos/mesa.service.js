import angular from 'angular';

class MesaService {

    constructor($http) {
        this.$http = $http;
        //const apiBase = "http://localhost:9090/projeto/api";
        const apiBase = "http://localhost:8080";
        const header = { 'Content-Type': 'application/json' };
        this.path =  apiBase + "/mesa";
        this.header = header;
        
    }
    
    getMesas() {
        return this.$http.get(this.path,this.header);
    }
    getMesa(id){
        return this.$http.get(this.path+'/'+id,this.header);
    }
    salvar(mesa){
        return this.$http.post(this.path,mesa,this.header);
    }
    editar(mesa){
        return this.$http.put(this.path,mesa,this.header);
    }
    apagar(id){
        return this.$http.delete(this.path+'/'+id,this.header);
    }
    adcionarCadeira(cadeira){
        return this.$http.post(this.path+'/cadeira',cadeira,this.header);
    }  
    removerCadeira(id){
        return this.$http.delete(this.path+'/cadeira/'+id,this.header);
    }
}

export default angular.module('services.mesa-service', [])
.service('mesaService', MesaService).name;