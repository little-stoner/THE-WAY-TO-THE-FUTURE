import * as React from 'react';

type HeaderProps = {
    text: string
}

function Header(props: HeaderProps) {
    React.useEffect(() => {
        console.log(document.querySelector("#myHeader"));
    })
    
    return (
        <h1>{props.text}</h1>
    )
}

Header.displayName = "Header";

export default Header;
