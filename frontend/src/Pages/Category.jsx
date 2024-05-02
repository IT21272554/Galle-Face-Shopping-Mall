import { Search } from '@mui/icons-material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { toast } from 'react-toastify';
import ItemBox from '../Components/ItemBox';
import Navbar from '../Components/NavBar';

const Category = () => {
    const { id } = useParams();
    //console.log(process.env.REACT_APP_API_URL);
    const [items, setItems] = useState([])
    const [products, setProducts] = useState([]);
    const [text, setText] = useState('');
    const [popularItems, setPopularItems] = useState([])


    const getItemsInCategory = async () => {
        try {
            const res = await axios.get(`${process.env.REACT_APP_API_URL}/search/category/${id}`)
            console.log(res.data);
            setItems(res.data)
        } catch (error) {
            console.log(error);
        }
    }

    const searchItems = async () => {
        try {
            console.log('Items fetching...');
            if (text) {
                console.log(text);
                const items = await axios.get(`${process.env.REACT_APP_API_URL}/search/items/category/${id}/${text}`)
                console.log(items.data);
                if(items?.data?.length < 1){
                    toast.error('No items')
                }
                setProducts(items.data);
            }
        } catch (error) {
            console.log(error);
        }
    }


    const getPop = async ()=>{
        try {
            const res = await axios.get(`${process.env.REACT_APP_API_URL}/item/popular`);
            setPopularItems(res.data)
        } catch (error) {
            console.log(error);
        }
    }
    useEffect(() => {

        searchItems();


    }, [text])

    useEffect(() => {
        getItemsInCategory()
        getPop()
    }, [])

    return (
        <div>
            <Navbar />
            <h2>Items</h2>
            <div className='px-2 py-2 my-4 flex rounded-lg w-full'>
                <input type="text" name="" id="" placeholder={`Search ${id}`} className='px-4 py-2 w-full' onChange={e => setText(e.target.value)} />
                <button className='p-2 bg-green-300 w-max' onClick={searchItems}><Search /></button>
            </div>
            <div className='grid grid-cols-2 md:grid-cols-3 xl:grid-cols-8 gap-2'>
                {
                    products.length < 1 && items.map((it) => (
                        <ItemBox item={it} />
                    ))
                }
                {
                   products.length > 0 && products.map((it) => (
                        <ItemBox item={it} />
                    ))
                }
            </div>
            <br />
            <h2>Popular Items</h2>
            <div className='grid grid-cols-2 md:grid-cols-3 xl:grid-cols-8 gap-2'>
            {
                   popularItems.length > 0 && popularItems.map((it) => (
                        <ItemBox item={it} />
                    ))
                }
            </div>
        </div>
    )
}

export default Category