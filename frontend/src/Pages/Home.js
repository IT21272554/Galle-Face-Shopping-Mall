import React from "react";
import BannerBackground from "../Assets/home-banner-background.png";
import BannerImage from "../Assets/home-banner-image.png";
import Navbar from "../Components/NavBar";
import Footer from "../Components/Footer";
import About from "../Components/About";
import Contact from "../Components/Contact";
import { FiArrowRight } from "react-icons/fi";

const Home = () => {
  return (
    <div className="home-container">
      <Navbar />
      <div className="home-banner-container">
        <div className="home-bannerImage-container">
          <img src={BannerBackground} alt="" />
        </div>
        <div className="home-text-section">
          <h1 className="primary-heading">
            Black Friday Best Deal
          </h1>
          <p className="primary-text">
          Get ready to save big this Black Friday! Unbeatable discounts await you. Don't miss out on our best deals yet!
          </p>
          <button className="secondary-button">
            Shop Now <FiArrowRight />{" "}
          </button>
        </div>
        <div className="home-image-section">
          <img src={BannerImage} alt=""/>
        </div>
        
      </div>
      <About/>
      <Contact/>
      <Footer/>
    </div>
  );
};

export default Home;