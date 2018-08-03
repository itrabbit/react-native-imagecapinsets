import React from 'react';
import {
    ImageBackground,
} from 'react-native';

import ImageResizeMode from 'react-native/Libraries/Image/ImageResizeMode';

// noinspection JSUnusedGlobalSymbols
class ImageCapInset extends React.Component {
    render() {
        // noinspection JSUnresolvedVariable
        return (
            <ImageBackground {...this.props} resizeMode={ImageResizeMode.stretch} />
        );
    }
}

ImageCapInset.propTypes = ImageBackground.propTypes;

ImageCapInset.defaultProps = ImageBackground.defaultProps;

export default ImageCapInset;