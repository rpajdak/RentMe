import React, {useState, useEffect} from "react";
import "../../../css/payment.css";

function Payment() {

    return(
        <div className="row">
            <div className="col-75">
                <div className="container">
                    <form>
                        <div className="row">
                            <div className="col-50">
                                <h3>Billing Address</h3>
                                <label htmlFor="fname"><i className="fa fa-user"/> Full Name</label>
                                <input type="text" id="fname" name="firstname" placeholder="John M. Doe"/>
                                <label htmlFor="email"><i className="fa fa-envelope"/> Email</label>
                                <input type="text" id="email" name="email" placeholder="john@example.com"/>
                                <label htmlFor="adr"><i className="fa fa-address-card-o"/> Address</label>
                                <input type="text" id="adr" name="address" placeholder="542 W. 15th Street"/>
                                <label htmlFor="city"><i className="fa fa-institution"/> City</label>
                                <input type="text" id="city" name="city" placeholder="New York"/>

                                <div className="row">
                                    <div className="col-50">
                                        <label htmlFor="zip">Zip-Code</label>
                                        <input type="text" id="zip" name="zip" placeholder="10001"/>
                                    </div>
                                </div>
                            </div>

                            <div className="col-50">
                                <h3 className="h3-text">Payment</h3>
                                <label className="label" htmlFor="cname">Name on Card</label>
                                <input type="text" id="cname" name="cardname" placeholder="John More Doe"/>
                                <label className="label" htmlFor="ccnum">Credit card number</label>
                                <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444"/>
                                <label className="label" htmlFor="expmonth">Exp Month</label>
                                <input type="text" id="expmonth" name="expmonth" placeholder="September"/>

                                <div className="row">
                                    <div className="col-50">
                                        <label htmlFor="expyear">Exp Year</label>
                                        <input type="text" id="expyear" name="expyear" placeholder="2018"/>
                                    </div>
                                    <div className="col-50">
                                        <label htmlFor="cvv">CVV</label>
                                        <input type="text" id="cvv" name="cvv" placeholder="352"/>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <label>
                            <input type="checkbox" checked="checked" name="sameadr"/> I accept all terms & conditions
                        </label>
                        <input type="submit" value="Book now!" className="btn"/>
                    </form>
                </div>
            </div>
        </div>

    )

}
export default Payment;