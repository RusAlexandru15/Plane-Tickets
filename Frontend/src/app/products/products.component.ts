import { Component } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
     constructor(){}

     ngOnInit():void {}

     //vector de produse
     products=[
        {id:1,name:'watch',price:'109',av:'available',type:'premium'} ,
        {id:2,name:'ball',price:'21',av:'not available',type:'premium'},
        {id:3,name:'hat',price:'19',av:'available',type:'regular'},
        {id:5,name:'pen',price:'15',av:'not available',type:'premium'},
        {id:6,name:'pencil',price:'15',av:'available',type:'regular'},
        {id:7,name:'umbrella',price:'15',av:'not available',type:'regular'}
     ];


     getTotalProducts(){
      return this.products.length;
     }

     getRegularProducts()
     {
      return this.products.filter(product=>product.type==='regular').length;
     }   

     getPremiumProducts(){
      return this.products.filter(product=>product.type==='premium').length;
     }



}
