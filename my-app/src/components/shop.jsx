import axios from 'axios';
import {useEffect, useState } from "react";
 
function Shop()
{
//Logic
  const [shopid, setId] = useState('');
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [category, setCategory] = useState("");
  const [shops, setShops] = useState([]);


 
useEffect(() => {
  (async () => await Load())();
  }, []);
 
 
  async function  Load()
  {
     const result = await axios.get(
         "http://localhost:8090/shop/getAll");
         setShops(result.data);
         console.log(result.data);
  }
 

  
     async function save(event)
    {
        event.preventDefault();
    try
        {
         await axios.post("http://localhost:8090/shop/save",
        {
            name: name,
            description: description,
            category: category
        });
          alert("Shop Create Successfully");
          setId("");
          setName("");
          setDescription("");
          setCategory("");
          Load();
        }
    catch(err)
        {
          alert("Shop Create Failed");
        }
   }

 
   async function editShop(shops)
   {
    setName(shops.name);
    setDescription(shops.description);
    setCategory(shops.category);
    setId(shops._id);
   }
 
   async function DeleteShop(shopid)
   {
        await axios.delete("http://localhost:8090/shop/delete/" + shopid); 
        alert("Shop deleted Successfully");
        Load();
   }
 
   async function update(event)
   {
    event.preventDefault();
 
   try
       {
        await axios.put("http://localhost:8090/shop/edit/" + shopid ,
       {

        name: name,
        description: description,
        category: category
       
       });
         alert("Shop Updated");
         setId("");
         setName("");
         setDescription("");
         setCategory("");
         Load();
       }
   catch(err)
       {
         alert("Shop Update Failed");
       }
  }

  //Design
  return (
    <div>
       <h1>Shops Details</h1>
       <div class="container mt-4" >
          <form>
             
              <div class="form-group">
                <label>Shop Name</label>
                <input  type="text" class="form-control" id="name"
                value={name}
                onChange={(event) =>
                  {
                    setName(event.target.value);      
                  }}
                />
              </div>


              <div class="form-group">
                <label>Shop Description</label>
                <input  type="text" class="form-control" id="description" 
                 value={description}
                  onChange={(event) =>
                    {
                      setDescription(event.target.value);      
                    }}
                />
              </div>

              <div class="form-group">
                <label>Shop Category</label>
                <input type="text" class="form-control" id="category" 
                  value={category}
                onChange={(event) =>
                  {
                    setCategory(event.target.value);      
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
      
      <th scope="col">Option</th>
    </tr>
  </thead>
       {shops.map(function fn(shop)
       {
            return(
            <tbody>
                <tr>
                <td>{shop.name}</td>
                <td>{shop.description}</td>
                <td>{shop.category}</td>       
                <td>
                    <button type="button" class="btn btn-warning"  onClick={() => editShop(shop)} >Edit</button>  
                    <button type="button" class="btn btn-danger" onClick={() => DeleteShop(shop._id)}>Delete</button>
                </td>
                </tr>
            </tbody>
            );
            })}
            </table>
       </div>
            );
        }
  
  export default Shop;