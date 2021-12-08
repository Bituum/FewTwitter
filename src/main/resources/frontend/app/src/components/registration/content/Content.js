import React from "react";
import "./content.css";

const Content = () => {
    return (
        <div className="content_item">
            <div className="content-box">
                <p>У <span className="definition">вселенной</span> есть <span className="package">начало</span>, но нет <span className="package">конца</span>.
                    <span className="conclusion"> Безграничность...</span>
                </p>
                <p>
                    У <span className="definition">звезд</span> тоже есть начало, но они гибнут из-за собственной <span className="package">силы</span>.
                    <span className="conclusion"> Ограниченность...</span>
                </p>
                <p>
                    <span className="definition">Мудрецы</span> <span className="package">глупее</span> всех на свете. <span className="conclusion">История</span> нам это доказала.
                </p>
                <p>
                    <span className="definition">Рыба</span>, живущая в океане, <span className="package">не знает</span> о мире на суше. Будь она <span className="package">разумна</span>, она бы также <span className="conclusion">погибла</span>.
                </p>
                <p>Назовем это последним предупреждением <span id="god">бога</span> для тех кто еще сопротивляется.</p>
            </div>
        </div>
    );
}

export default Content;