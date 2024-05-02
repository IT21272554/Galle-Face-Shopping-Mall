import axios from 'axios';
import {useEffect, useState } from "react";
 
function Item()
{
//Logic
const [itemid, setId] = useState('');
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [category, setCategory] = useState("");
  const [shopId, setShopId] = useState("");
  const [items, setItems] = useState([]);


 
useEffect(() => {
  (async () => await Load())();
  }, []);
 
 
  async function  Load()
  {
     const result = await axios.get(
         "http://localhost:8090/item/getAll");
         setItems(result.data);
         console.log(result.data);
  }
 

  
     async function save(event)
    {
        event.preventDefault();
    try
        {
         await axios.post("http://localhost:8090/item/save",
        {
            name: name,
            description: description,
            category: category,
            shopId: shopId
        });
          alert("Item Create Successfully");
          setId("");
          setName("");
          setDescription("");
          setCategory("");
          setShopId("");
          Load();
        }
    catch(err)
        {
          alert("Item Create Failed");
        }
   }

 
   async function editItem(items)
   {
    setName(items.name);
    setDescription(items.description);
    setCategory(items.category);
    setShopId(items.shopId);
    setId(items._id);
   }
 
   async function DeleteItem(itemid)
   {
        await axios.delete("http://localhost:8090/item/delete/" + itemid); 
        alert("Item deleted Successfully");
        Load();
   }
 
   async function update(event)
   {
    event.preventDefault();
 
   try
       {
        await axios.put("http://localhost:8090/item/edit/" + itemid ,
       {

        name: name,
        description: description,
        category: category,
        shopId: shopId
       
       });
         alert("Item Updated");
         setId("");
         setName("");
         setDescription("");
         setCategory("");
         setShopId("");
         Load();
       }
   catch(err)
       {
         alert("Item Update Failed");
       }
  }

  //Design
  return (
    <div>
       <h1>Items Details</h1>
       <div class="container mt-4" >
          <form>
             
              <div class="form-group">
                <label>Item Name</label>
                <input  type="text" class="form-control" id="name"
                value={name}
                onChange={(event) =>
                  {
                    setName(event.target.value);      
                  }}
                />
              </div>


              <div class="form-group">
                <label>Item Description</label>
                <input  type="text" class="form-control" id="description" 
                 value={description}
                  onChange={(event) =>
                    {
                      setDescription(event.target.value);      
                    }}
                />
              </div>

              <div class="form-group">
                <label>Item Category</label>
                <input type="text" class="form-control" id="category" 
                  value={category}
                onChange={(event) =>
                  {
                    setCategory(event.target.value);      
                  }}
                />
                </div>

               <div class="form-group">
                <label>Item ShopId</label>
                <input type="text" class="form-control" id="shopId" 
                  value={shopId}
                onChange={(event) =>
                  {
                    setShopId(event.target.value);      
                  }}
                /> 


              </div>
              <div>
              <button   class="btn btn-primary mt-4"  onClick={save}>Create</button>

              <button   class="btn btn-warning mt-4"  onClick={update}>Update</button>
              </div>   
            </form>
          </div>
                <br/>
<table class="table table-dark" align="center">
  <thead>
    <tr>
      <th scope="col">Item Name</th>
      <th scope="col">Item Description</th>
      <th scope="col">Item Category</th>
      <th scope="col">Item ShopId</th>
      
      <th scope="col">Option</th>
    </tr>
  </thead>
       {items.map(function fn(item)
       {
            return(
            <tbody>
                <tr>
                <td>{item.name}</td>
                <td>{item.description}</td>
                <td>{item.category}</td>
                <td>{item.shopId}</td>        
                <td>
                    <button type="button" class="btn btn-warning"  onClick={() => editItem(item)} >Edit</button>  
                    <button type="button" class="btn btn-danger" onClick={() => DeleteItem(item._id)}>Delete</button>
                </td>
                </tr>
            </tbody>
            );
            })}
            </table>
       </div>
            );
        }
  
  export default Item;