import AbstractService from "./AbstractService.js";

export default class NegozioService extends AbstractService {
        
        constructor(){
            super();
            this.url = this.baseUrl + "/negozi"        
        }
        
    async all() {
        const data = await fetch(this.url, {
            method: 'get',
            headers: {
                'Accept': 'application/json'
            }
        })
                .then(response => response.json())
                .catch(res => console.error(res))
        return data;
    }     
    
    async find(id) {
        const data = await fetch(this.url + "/" + id, {
            method: 'get',
            headers: {
                'Accept': 'application/json'
            }
        })
                .then(response => response.json())
                .catch(res => console.error(res))
        return data;
    }

    async create(json) {
        return await fetch(this.url,{
            method: 'post',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(json)

        });
    }

    async update(id, json) {
        return await fetch(this.url + "/" + id,{
            method: 'put',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(json)

        });
    }

    async delete(id) {
        return await fetch(this.url + "/" + id, {
            method: 'delete',
            headers: {
                'Accept': 'application/json'
            }
        })
                .catch(res => console.error(res))
    }
        
        
}

