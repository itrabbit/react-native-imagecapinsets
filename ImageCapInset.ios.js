import React from 'react';
import {
    ImageBackground,
} from 'react-native';

// noinspection JSUnusedGlobalSymbols
class ImageCapInset extends React.Component {
    render() {
        // noinspection JSUnresolvedVariable
        return (
            <ImageBackground {...this.props} resizeMode={'stretch'} />
        );
    }
}

ImageCapInset.propTypes = ImageBackground.propTypes;

ImageCapInset.defaultProps = ImageBackground.defaultProps;

export default ImageCapInset;